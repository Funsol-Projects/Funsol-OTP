package com.scorpio.otptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.scorpio.otpsdk.model.OtpRequest
import com.scorpio.otpsdk.viewModels.OTPViewModel
import com.scorpio.otptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var otpSend = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val alertDialog = AlertDialog.Builder(this)
            .setTitle("Sending OTP")
            .setMessage("Please wait while we send the OTP.")
            .setCancelable(false)
            .create()

        val subject = "this is test subject"
        val email = "osamamumtaz96@gmail.com"
        val upper = "Hello!\nThis is your otp"
        val lower = "Regards!\nOTP Sender App"

        val authToken = ""

        val otpViewModel = ViewModelProvider(this)[OTPViewModel::class.java]
        otpViewModel.otpResponse.observe(this) {
            it?.let {
                if (it.status == "success") {
                    Toast.makeText(this, "otp sent!", Toast.LENGTH_SHORT).show()
                    otpSend = it.data
                } else {
                    Toast.makeText(this, "otp not sent, Please try again!", Toast.LENGTH_SHORT).show()
                }
                alertDialog.dismiss()
            }
        }

        val requestServer = OtpRequest(subject, email, upper, lower)

        with(binding) {
            btnSendOtp.setOnClickListener {
                alertDialog.show()
                otpViewModel.getOtpResponse(authToken, requestServer)
            }

            btnVerifyOtp.setOnClickListener {
                if (edReceiveOtp.text.trim().toString() == otpSend.toString()) {
                    Toast.makeText(this@MainActivity, "otp verified", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this@MainActivity, "otp not verified", Toast.LENGTH_SHORT).show()
            }
        }

    }
}