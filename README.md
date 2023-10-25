# Funsol-OTP (SDK to send OTP for email verification)

[![](https://jitpack.io/v/Funsol-Projects/Funsol-OTP.svg)](https://jitpack.io/#Funsol-Projects/Funsol-OTP)

Funsol-OTP is an OTP sending library that is used to send OTP for email verification. Developers can
easily integrate this dependency in their projects and send OTP to verify user emails.

## Getting Started

### Step 1

Add maven repository in project level build.gradle or in latest project setting.gradle file

```
    repositories {
        google()
        mavenCentral()
        maven { url "https://jitpack.io" }
    }
```  

### Step 2

Add Funsol-OTP dependencies in App level build.gradle.

```
    dependencies {
        implementation 'com.github.Funsol-Projects:Funsol-OTP:1.1.1'
    }
```  

### Step 3

Initialize OTPViewModel using ViewModelProvider where `this` is the ViewLifecycleOwner

```
    val otpViewModel = ViewModelProvider(this)[OTPViewModel::class.java]
```

### Step 4
Send OTP using below line. Send `authToken` which is already given to you, and your `email`. You will get boolean result in callback.
```
    otpViewModel.sendOtp(authToken, email){ otpResult -> 
            
    }
```

### Step 5

You can also send custom `subject`, `upper` and `lower` text in the otp email by following way.

```
    val otpRequestServer = OtpRequest(subject, upper, lower)
    otpViewModel.sendOtp(authToken, email, otpRequestServer){ otpResult -> 
            
    }
```

### Step 6

Finally verify the otp by calling below method with user given OTP.

```
    otpViewModel.verifyOtp(otpFromUser)
```

## License

MIT License

Copyright (c) [2022] 

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute,
sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES
OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

