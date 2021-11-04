/*
 * Copyright 2020 New Vector Ltd - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package org.matrix.android.sdk.internal.session.contentscanning

import okhttp3.ResponseBody
import org.matrix.android.sdk.internal.network.NetworkConstants
import org.matrix.android.sdk.internal.session.contentscanning.model.DownloadBody
import org.matrix.android.sdk.internal.session.contentscanning.model.ScanResponse
import org.matrix.android.sdk.internal.session.contentscanning.model.ServerPublicKeyResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * https://github.com/matrix-org/matrix-content-scanner
 */
internal interface ContentScanApi {

    @POST(NetworkConstants.URI_API_PREFIX_PATH_MEDIA_PROXY_UNSTABLE + "download_encrypted")
    suspend fun downloadEncrypted(@Body info: DownloadBody): ResponseBody

    @POST(NetworkConstants.URI_API_PREFIX_PATH_MEDIA_PROXY_UNSTABLE + "scan_encrypted")
    suspend fun scanFile(@Body info: DownloadBody): ScanResponse

    @GET(NetworkConstants.URI_API_PREFIX_PATH_MEDIA_PROXY_UNSTABLE + "public_key")
    suspend fun getServerPublicKey(): ServerPublicKeyResponse

    @GET(NetworkConstants.URI_API_PREFIX_PATH_MEDIA_PROXY_UNSTABLE + "scan/{domain}/{mediaId}")
    suspend fun scanMedia(@Path(value = "domain") domain: String, @Path(value = "mediaId") mediaId: String): ScanResponse
}
