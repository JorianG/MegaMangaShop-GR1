package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande7pRemiseRoyaumeUnis : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander 80 livres au Royaume-Unis") {
        given("un panier de 80 livres à 10€") {
            val panier = Panier(Pays.ROYAUME_UNI)

            panier.ajouterManga(Manga("test", 10.0), 80)

            When("je calcule le total avec remise de 7%") {
                val total = panier.total

                Then("le total TTC est de 913.63€") {
                    total shouldBeExactly 913.63
                }
            }
        }

        given("un panier de 80 livres à 9.90€") {
            val panier = Panier(Pays.ROYAUME_UNI)

            panier.ajouterManga(Manga("test", 9.90), 80)

            When("je calcule le total avec remise de 7%") {
                val total = panier.total

                Then("le total TTC est de 904.5€") {
                    total shouldBeExactly 904.5
                }
            }
        }

        given("un panier de 10 livres à 19.99€") {
            val panier = Panier(Pays.ROYAUME_UNI)

            panier.ajouterManga(Manga("test", 19.99), 40)

            When("je calcule le total avec remise de 7%") {
                val total = panier.total

                Then("le total TTC est de 913.18€") {
                    total shouldBeExactly 913.18
                }
            }
        }

        given("un livre à -10€") {

            Then("une exception IllegalArgument est levée ") {
                shouldThrow<IllegalArgumentException> { Manga("test", -10.0) }
            }
        }
    }
})
