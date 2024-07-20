package com.example.ghtk_ex1.b2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.abs

class B2ViewModel : ViewModel() {
    private val _xA = MutableLiveData<Double>()
    val xA: LiveData<Double> =_xA

    private val _yA = MutableLiveData<Double>(0.0)
    val yA: LiveData<Double> = _yA

    private val _x1 = MutableLiveData<Double>(0.0)
    val x1: LiveData<Double> = _x1

    private val _y1 = MutableLiveData<Double>(0.0)
    val y1: LiveData<Double> = _y1

    private val _x2 = MutableLiveData<Double>(0.0)
    val x2: LiveData<Double> = _x2

    private val _y2 = MutableLiveData<Double>(0.0)
    val y2: LiveData<Double> = _y2

    private val _x3 = MutableLiveData<Double>(0.0)
    val x3: LiveData<Double> = _x3

    private val _y3 = MutableLiveData<Double>(0.0)
    val y3: LiveData<Double> = _y3

    fun setXA(value: Double) {
        _xA.value = value
    }

    fun setYA(value: Double) {
        _yA.value = value
    }

    fun setX1(value: Double) {
        _x1.value = value
    }

    fun setY1(value: Double) {
        _y1.value = value
    }

    fun setX2(value: Double) {
        _x2.value = value
    }

    fun setY2(value: Double) {
        _y2.value = value
    }

    fun setX3(value: Double) {
        _x3.value = value
    }

    fun setY3(value: Double) {
        _y3.value = value
    }

    private var _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    // Tính diện tích tam giác
    private fun calculateTriangleArea(
        x1: Double?, y1: Double?, x2: Double?, y2: Double?,
        x3: Double?, y3: Double?): Double {
        val area = 0.5 * abs(
            x1!! * (y2!! - y3!!) + x2!! * (y3 - y1!!) + x3!! * (y1 - y2),
            )
        return area
    }

    // Xác định kết quả
    fun setResult(){
        val triangleArea = calculateTriangleArea(x1.value, y1.value, x2.value, y2.value, x3.value, y3.value)
        val sum4pointsArea =
            calculateTriangleArea(xA.value, yA.value, x1.value, y1.value, x2.value, y2.value) +
                    calculateTriangleArea(xA.value, yA.value, x1.value, y1.value, x3.value, y3.value) +
                    calculateTriangleArea(xA.value, yA.value, x2.value, y2.value, x3.value, y3.value)
        if (triangleArea == sum4pointsArea) {
            _result.value = "Điểm A nằm trong tam giác"
        } else {
            _result.value = "Điểm A không nằm trong tam giác"
        }
    }

}