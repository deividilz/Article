if(readOk == false){
	if(prioritySignalAvoid == 1){
		if(time > bestTime+240){
			truck.jumpTo(routePonts[sequence+1].getLatitude(), routePonts[sequence+1].getLongitude());
		}
	}else if(prioritySignalAvoid == 2){
		if(timeAvoidSegment > bestTimeAvoid+240){
			truck.jumpTo(routePonts[sequence+1].getLatitude(), routePonts[sequence+1].getLongitude());
		}
	}else if(prioritySignalAvoid == 0){
		if(time > bestTime+240 || timeAvoidSegment > bestTimeAvoid+240){
			truck.jumpTo(routePonts[sequence+1].getLatitude(), routePonts[sequence+1].getLongitude());
		}
	}	
}

if(bestRoute != null && readOk == true && truck.isMoving() == true && savePoint == false)
	if(truck.distanceTo(bestRoute)/1000 <  2){
		routeLinks[sequenceLinks][0] = truck.getLatitude();
		routeLinks[sequenceLinks++][1] = truck.getLongitude();	
		savePoint = true;
		distanceSave = 0;
		System.out.println("Salvando ponto próximo cidade: " +bestRoute);
	}

if(readOk == true && truck.isMoving() == true){
	double distanceCalcule = 0.0;
	if(sequence+1<sizeRoutes-1)
		distanceCalcule = (routePonts[sequence].distanceTo(routePonts[sequence+1])/1000)/2;
	
	if(bestRoute != null)
		distanceCalcule = (routePonts[sequence].distanceTo(bestRoute)/1000)/2;	
	
	if(distanceSave/1000 >= distanceCalcule && distanceCalcule >= 25){
		routeLinks[sequenceLinks][0] = truck.getLatitude();
		routeLinks[sequenceLinks++][1] = truck.getLongitude();
		distanceSave = 0;
		System.out.println("Salvou ponto extra distancia");
		return;
	}
}
else if(distanceSave/1000 <= 15 && readOk == true && truck.isMoving() == true && activateSignal == false){
	for(City city : cities){
		if(truck.distanceTo(city)/1000 < 0.5){	
			if(city.distanceTo(routePonts[sequence])/1000 > 8){
				routeLinks[sequenceLinks][0] = truck.getLatitude();
				routeLinks[sequenceLinks++][1] = truck.getLongitude();
				System.out.println("Salvou ponto extra rodovia");
				distanceSave=0;
				return;
			}					
		}
	}
}