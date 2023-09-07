package com.msg.data.remote.datasource.auth

import com.msg.data.remote.dto.auth.LoginRequest
import com.msg.data.remote.dto.auth.LoginResponse
import com.msg.data.remote.network.AuthApi
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authApi: AuthApi
): AuthDataSource {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse = authApi.login(loginRequest)

    override suspend fun tokenReissue(): LoginResponse = authApi.tokenReissue()
}