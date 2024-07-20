package com.example.ghtk_ex1.b1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class B1ViewModel : ViewModel() {

    private val _currentString = MutableLiveData("")
    val currentString: LiveData<String> = _currentString

    private val _result = MutableLiveData("")
    val result: LiveData<String> = _result


    private val _resultList = MutableLiveData<List<CharacterModel>>(mutableListOf())
    val resultList: LiveData<List<CharacterModel>> = _resultList


    fun setCurrentString(string: String) {
        _currentString.value = string
    }

    // Hàm trả về số lượng mỗi ký tự xuất hiện trong chuỗi
    fun setResultList() {
        val charArray = currentString.value!!.toCharArray()

        val countMap = mutableMapOf<Char, Int>()

        for (character in charArray) {
            if (countMap.containsKey(key = character)) {
                countMap[character] = countMap[character]!! + 1
            } else {
                countMap[character] = 1
            }
        }

        _resultList.value = countMap.map { (character, occurrence) ->
            CharacterModel(
                character.toString(),
                occurrence.toString()
            )
        }
    }

}