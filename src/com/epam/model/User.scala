package com.epam.model

class User(val name: String, val wallName: String) {
    
    val WALL_FILE_EXTENTION = ".txt"
    
    def getWallFileName: String = name + WALL_FILE_EXTENTION
}