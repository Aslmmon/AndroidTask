package com.example.rabbittask.model

data class HomePageContent(
    var hotSpotsList: List<HotSpot>,
    var eventsList: List<Event>,
    var attractionList: List<Attraction>
)