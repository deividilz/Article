if(truck.isMoving() && timeWindow == true && started == false){
	if (latitude != 0 && longitude != 0){
		distanceJorney += truck.distanceTo(latitude, longitude);
		latitude = truck.getLatitude();
		longitude = truck.getLongitude();
	}else{
		latitude = truck.getLatitude();
		longitude = truck.getLongitude();
	}
}