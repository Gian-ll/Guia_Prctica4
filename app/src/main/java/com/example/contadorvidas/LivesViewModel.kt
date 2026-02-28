package com.example.contadorvidas
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class LivesViewModel : ViewModel() {
    private val _vidas = MutableLiveData(3)
    val vidas: LiveData<Int> get()= _vidas

    private val _mensaje = MutableLiveData("Estado: Activo")
    val mensaje: LiveData<String> get() = _mensaje

    private val _botonAC = MutableLiveData (true)
    val botonAc: LiveData<Boolean> get() = _botonAC

    fun reducirVida() {
        val actual = _vidas.value ?: 0
        if (actual > 0) {
            _vidas.value = actual - 1
        }
        if (_vidas.value == 0) {
            _botonAC.value = false
            _mensaje.value = "Estado: Game Over"
        }
    }
}