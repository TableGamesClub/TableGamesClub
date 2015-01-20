<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Geocoding service</title>
    <style>
      html, body, #map-canvas {
        height:75%;
        width:75%;
        margin: 10px;
        padding: 10px;
        text-shadow: 3px 3px 3px #cccccc
      }
      #panel {
        position: absolute;
/*         top: 5px; */
        left: 50%;
        margin-left: -180px;
        z-index: 5;
/*         background-color: #fff; */
        padding: 5px;
/*         border: 1px solid #999; */
      }
      body1
      {
        margin: 5px;
        padding: 5px
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
    <script>
var geocoder;
var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(-34.397, 150.644);
  var mapOptions = {
    zoom: 17,
    center: latlng
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
}

function codeAddress() {
  var address = document.getElementById('address').value;
  geocoder.geocode( { 'address': address}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
}

google.maps.event.addDomListener(window, 'load', initialize);
google.maps.event.addDomListener(window, 'load', codeAddress);

    </script>
  </head>
  <body1>
  <%
	//Member dao1 = new MemberDAOHibernate();
	//StoreMemberDAO dao2 = new StoreMemberDAOJdbc();
  %>
<%--   <h3><%= dao1.select("Shellen").getMemberAddress()%></h3> --%>
  </body1>
  <body>

    </div>
    <div id="map-canvas"></div>
  </body>
</html>