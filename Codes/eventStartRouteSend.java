if(started == true){
	if(sequence == 0 && truck.isMoving()==false){
		if(truck.distanceTo(routePonts[0]) < 1){
			if(tripStartTime+hour < routePonts[0].hourOpen || tripStartTime+hour > routePonts[0].hourClose && timeWindow == true){
				System.out.println("Aguardando horário");
				return;
			}else{
				if(timeWait < timeReturn && calculated == true){
			
					if(readOk == true)
						activateTime = true;
					
					timeWait++;
					System.out.println("Esta aguardando, tempo: " + timeWait);
					return;
				}
				
				System.out.println("Pode iniciar");
				if(calculated == false && routes.get(0).manual == 0 && timeFirstLastPoint == true){
					timeReturn = verifyStoped();
					calculated =  true;
					return;
				}	
				if(routePonts[1].manual == 1 && (activateSignal == true || activeAvoid == true)){
					truck.moveTo(routePonts[2]);
					sequence++;
				}else{
					truck.moveTo(routePonts[1]);
				}
					
				if(activateSignal == true || activeAvoid == true)
					readOk = false;
			}
			//getEngine().pause();
		}
	}
	
	//if(truck.isMoving())
		//calculated = false;
}