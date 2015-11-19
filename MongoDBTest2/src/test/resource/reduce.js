function(key, emits){
	var returnVal = {};
    var count = 0;
    for(var i in emits){
    	var age = emits[i].age;
        
        if(age != undefined){
            if(returnVal[age] != null && returnVal[age] != undefined && returnVal[age] != NaN){
                count = returnVal[age];
            }else{
                count = 0;
            }
            returnVal[age] = count + 1;
        }
        
       
    }
    return returnVal;
}
