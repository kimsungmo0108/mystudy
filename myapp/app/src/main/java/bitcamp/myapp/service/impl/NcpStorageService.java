package bitcamp.myapp.service.impl;

import bitcamp.myapp.service.StorageService;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.InputStream;
import java.util.UUID;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NcpStorageService implements StorageService, InitializingBean {

  private static Log log = LogFactory.getLog(NcpStorageService.class);
  final AmazonS3 s3;
  String endPoint;
  String regionName;
  String accessKey;
  String secretKey;

  public NcpStorageService(
      @Value("${ncp.ss.endpoint}") String endPoint,
      @Value("${ncp.ss.regionname}") String regionName,
      @Value("${ncp.accesskey}") String accessKey,
      @Value("${ncp.secretkey}") String secretKey) {
    this.endPoint = endPoint;
    this.regionName = regionName;
    this.accessKey = accessKey;
    this.secretKey = secretKey;

    // S3 client
    this.s3 = AmazonS3ClientBuilder.standard()
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, regionName))
        .withCredentials(
            new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
        .build();
  }

  @Override
  public String upload(String bucketName, String path, MultipartFile multipartFile)
      throws Exception {
    try (InputStream fileIn = multipartFile.getInputStream()) {

      // upload local file
      String filename = UUID.randomUUID().toString();
      String objectName = path + filename;

      // 서버에 업로드할 파일의 정보를 준비
      ObjectMetadata objectMetadata = new ObjectMetadata();
      objectMetadata.setContentType(multipartFile.getContentType());

      // 서버에 업로드 요청 정보 생성
      PutObjectRequest putObjectRequest = new PutObjectRequest(
          bucketName,
          objectName,
          fileIn,
          objectMetadata
      ).withCannedAcl(CannedAccessControlList.PublicRead); // 업로드한 파일의 접근 범위 설정

      // 서버에 업로드 실행
      s3.putObject(putObjectRequest);

      log.debug(String.format("Object %s has been created.\n", objectName));

      return filename;

    }
  }

  @Override
  public void afterPropertiesSet() {
    log.debug(String.format("endPoint = %s", this.endPoint));
    log.debug(String.format("regionName = %s", this.regionName));
    log.debug(String.format("accessKey = %s", this.accessKey));
    log.debug(String.format("secretKey = %s", this.secretKey));
  }
}
