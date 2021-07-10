package com.example.animalshelter

class animal {
    var AnimalType :String? = null
    var ConditionFound :String? = null
    var Description :String? = null
    var Location :String? = null
    var Image :String? = null

    constructor(){

    }


    constructor(
        AnimalType: String?,
        ConditionFound: String?,
        Description: String?,
        Location: String?,
        Breed: String?,
        Image: String?
    ) {
        this.AnimalType = AnimalType
        this.ConditionFound = ConditionFound
        this.Description = Description
        this.Location = Location
        this.Breed = Breed
        this.Image = Image
    }


}