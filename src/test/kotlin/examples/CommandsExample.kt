package examples

import com.github.ivan_osipov.clabo.dsl.bot

fun main(args: Array<String>) {
    bot(exampleProperties) longPolling {

        configure {
            helloMessage("Hello! I'm Bot based on commands. Write '/'")
            updates {
                timeout = 3000
            }
        }

        commands {
            register("say_no") {
                it.update.message answer "No!"
            }
            registerForUnknown {
                it.update.message answer "Unknown command"
            }
        }

        onStart {
            println("Start with ${it.update.message?.from?.username}")
            it.update.message answer "I'm starting"
        }

        onHelp {
            println("Help with ${it.update.message?.from?.username}")
            it.update.message answer "I cannot help you"
        }

        onSettings {
            println("Settings with ${it.update.message?.from?.username}")
            it.update.message answer "I don't have settings"
        }
    }
}