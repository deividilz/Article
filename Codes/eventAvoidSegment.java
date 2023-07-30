int find = 0;

if(readOk == false && activeAvoid == true && started == true) {
	for(Avoid avoid:avoids){
		if(truck.distanceTo(avoid)/1000 < avoid.ray){
			find++;
			break;
		}		
	}
	
	if(find > 0){
		timeAvoidSegment++;
		if(truck.isMoving()){
			if (latitudeAvoid != 0 && longitudeAvoid != 0){
				distanceInAvoid += truck.distanceTo(latitudeAvoid, longitudeAvoid);				 
				latitudeAvoid = truck.getLatitude();
				longitudeAvoid = truck.getLongitude();
			}else{
				latitudeAvoid = truck.getLatitude();
				longitudeAvoid = truck.getLongitude();
			}
		}
	}
}