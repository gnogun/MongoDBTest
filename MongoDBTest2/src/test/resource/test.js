map = function() {
	emit(this.age, 1);
}

reduce = function(key, emits) {
	var count = 0;
	for ( var i in emits) {

		count += emits[i];
	}

	return count;
}

db.User2.mapReduce(map, reduce, {
	"query" : {
		$and: [
		       {"gender" : true},
		       {"age": { $lt: 30}}
		       ]
	},
	"out" : "user_mapreduce_age_male_20s"
})