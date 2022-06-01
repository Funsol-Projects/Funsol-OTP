package com.scorpio.otpsdk.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scorpio.otpsdk.model.OtpRequest
import com.scorpio.otpsdk.model.OtpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OTPViewModel : ViewModel() {

    private val _otpResponse = MutableLiveData<OtpResponse>(null)
    val otpResponse: LiveData<OtpResponse> = _otpResponse

    fun getOtpResponse(auth_token: String, requestServer: OtpRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            _otpResponse.postValue(OTPRepository.getOtpResponse(auth_token, requestServer))
        }
    }
}