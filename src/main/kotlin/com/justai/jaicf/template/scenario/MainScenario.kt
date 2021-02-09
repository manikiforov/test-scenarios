package com.justai.jaicf.template.scenario

import com.justai.jaicf.channel.alexa.alexa
import com.justai.jaicf.channel.jaicp.chatwidget
import com.justai.jaicf.channel.slack.slack
import com.justai.jaicf.channel.telegram.telegram
import com.justai.jaicf.channel.yandexalice.alice
import com.justai.jaicf.generic.ChannelTypeToken
import com.justai.jaicf.model.scenario.Scenario

object MainScenario : Scenario() {

    init {
        state("Start") {
            globalActivators {
                regex("/start")
                intent("LaunchRequest")
            }
            action {
                reactions.say("Начнём!")
            }
        }

        state("Привет") {
            activators {
                intent("Привет")
                intent("HelloWorldIntent")
            }

            action {
                reactions.alexa?.say("Алекса приветсвует!")
                reactions.say("Привет!")
            }
        }


        state("Пока") {
            activators {
                intent("Пока")
                intent("AMAZON.StopIntent")
            }

            action {
                reactions.alexa?.say("Алекса прощается с тобой!")
                reactions.say("Скоро увидимся!")
            }
        }

        state("Где я") {
            activators {
                regex("Где я")
                regex("test test")
            }

            action {
                telegram {
                    reactions.say("Ты пишешь в Телеграмме")
                    reactions.image("https://logos-download.com/wp-content/uploads/2016/07/Telegram_logo_icon.png")
                    reactions.buttons("Я знаю что я в Телеграм")
                }
                slack {
                    reactions.say("Ты пишешь в Слаке")
                    reactions.image("https://rabota-na-kompjutere.ru/wp-content/uploads/2016/04/hashteg-768x768.png")
                    reactions.buttons("Я знаю что я в Слак")
                }
                alexa {
                    reactions.say("You're in Alexa Channel")
                    //reactions.image("http://botlister.com/uploads/platform/Amazon%20Alexa/alexa-skills-icon.png")
                    //reactions.buttons("Я знаю что я в Алексе")
                }
                chatwidget {
                    reactions.say("Ты пишешь в Чатвиджет")
                    reactions.image("https://techsee.me/wp-content/uploads/2019/02/self-service-platforms-.jpg")
                    reactions.buttons("Я знаю что я в Чатвиджете")
                }
            }

            fallback {
                reactions.say("Мне пока нечего сказать...")
            }
        }
    }
}
