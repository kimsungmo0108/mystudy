var t = [];

var map = new naver.maps.Map('map', {
  center: new naver.maps.LatLng(37.3700065, 127.121359),
  zoom: 14
});

var polyline = new naver.maps.Polyline({
  map: map,
  strokeColor: '#5347AA',
  strokeWeight: 2
});

naver.maps.Event.addListener(map, 'click', function(e) {

  var point = e.coord;

  // 마커 생성
  var mark = new naver.maps.Marker({
    map: map,
    position: point
  });


  // Bootstrap 모달을 표시합니다.
  mark.addListener('click', function() {

    // Bootstrap 모달을 표시합니다.
    $('#markerModal').modal('show');

  });

  // 모달창에서 삭제를 눌렀을 때 마커삭제, 모달창 숨김
  $('#deleteButton').click( function() {
    markerDelete(mark);
    $('#markerModal').modal('hide');
  });

  // 마커를 삭제할 때 호출되는 함수
  function markerDelete(marker) {
    marker.setMap(null);
 }





// 저장 버튼
var addButton = $('#addButton');
var tripOrder = $('#tripOrder').val();
var postTitle = $('#postTitle').val();
var postContent = $('#postContent').val();
var recruitBoardId = $('#recruitBoardId').val();
var tripDate = $('#tripDate').val();
var latitude = point.latitude;
var longitude = point.longitude;

    let planBoard = {
      tripOrder : tripOrder,
      title : postTitle,
      content : postContent,
      recruitBoardId : recruitBoardId,
      tripDate : tripDate,
      latitude : latitude,
      longitude : longitude
    };
    console.log(planBoard);
// <!--  addButton.click( function() {-->

// <!--      $.ajax({-->
// <!--        url: '/plan/add',-->
// <!--        type: 'POST',-->
// <!--        contentType: false,-->
// <!--        processData: false,-->
// <!--        data:planBoard-->
// <!--      })-->
// <!--    });-->




});

