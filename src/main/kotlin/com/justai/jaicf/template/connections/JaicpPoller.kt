package com.justai.jaicf.template.connections

import com.justai.jaicf.channel.alexa.AlexaChannel
import com.justai.jaicf.channel.jaicp.DEFAULT_PROXY_URL
import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.jaicp.channels.ChatApiChannel
import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.channel.jaicp.channels.TelephonyChannel
import com.justai.jaicf.channel.slack.SlackChannel
import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.channel.yandexalice.AliceChannel
import com.justai.jaicf.template.accessToken
import com.justai.jaicf.template.templateBot

fun main() {
    JaicpPollingConnector(
        botApi = templateBot,
        accessToken = accessToken,
        channels = listOf(
            ChatApiChannel,
            ChatWidgetChannel,
            TelephonyChannel,
            TelegramChannel,
            AlexaChannel,
            SlackChannel
        ),
        url = "http://test-ha01.lo.test-ai.net/chatadapter"
    ).runBlocking()
}
