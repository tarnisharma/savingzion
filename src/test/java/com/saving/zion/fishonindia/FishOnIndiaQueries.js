db.listing.insert({
  "name": "Adolin",
  "listingId": "5",
  "locationCode": "GOA-IN",
  "operatorId": "25",
  "address": {
    "country": "India",
    "state": "Goa",
    "city": "Baga",
    "area": "Beach",
    "fullAddress": "Blah Blah Blah jhbfuihefr",
    "lat": 26.2176,
	"lon": 85.63953
  },
  "contact" :["111111111","019-111111111"],
  "rating":4.4,
  "content":[
  	"known for GT fishing","3D/2N tent also","best months to visit Nov-Feb"],
  "filters":{
  	"species" : [1,2],
  	"techniques" : [2,3],
  	"listingType" : 1,
  	"amenities" : [3,4,7,9],
  	"bestMonths" : [4,5,6],
  	"paymentOps" : [1,2],
  	"tags" : ["GTFishing","Beach"]
  },
  "fareAndAvailability": [
   	{       "avlDate": new ISODate("2017-12-01T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-02T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-03T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-04T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } 
  ]
});

db.listing.insert({
  "name": "Dalinar",
  "listingId": "5",
  "locationCode": "ANDM-IN",
  "operatorId": "2",
  "address": {
    "country": "India",
    "state": "Andaman & Nicobar Islands",
    "city": "Port Blair",
    "area": "Beach",
    "fullAddress": "Blah Blah Blah jhbfuihefr",
    "lat": 26.2176,
	"lon": 85.63953
  },
  "contact" :["111111111","019-111111111"],
  "rating":4.4,
  "content":[
  	"known for GT fishing","3D/2N tent also","best months to visit Nov-Feb"],
  "filters":{
  	"species" : [1,2],
  	"techniques" : [2,3],
  	"listingType" : 1,
  	"amenities" : [3,4,7,9],
  	"bestMonths" : [4,5,6],
  	"paymentOps" : [1,2],
  	"tags" : ["GTFishing","Beach"]
  },
  "fareAndAvailability": [
   	{       "avlDate": new ISODate("2017-12-01T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-02T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-03T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } ,
    {       "avlDate": new ISODate("2017-12-04T13:00:00Z"),       "availableCapacity": 7,       "fare": 1000,       "maxCapacity": 10,     } 
  ]
});

db.listing.find({});
db.filters.insert({
  "species" : {1:"Mahseer",
				2:"Golden Carp",
				3:"Trout",
				4:"GT"},	
  	"techniques" : {1:"Angling",
				2:"Bait fishing",
				3:"Fly Fishing",
				4:"Deep Dive Fishing"},	
  	"listingType" : {1:"Guide",
				2:"Charter Boat",
				3:"Tent"},
  	"amenities" : {1:"TV",
				2:"Fee Cancellation",
				3:"Pickup from airport"}, 
	"bestMonths" :{1:"Jan",
				2:"Feb",
				3:"Mar",
				4:"Apr",
				5:"May",
				6:"Jun"}, 
  	"paymentOps" : {1:"Advance NEFT",
				2:"Pay@Destination"}});
				
				
				
db.filters.find({});
