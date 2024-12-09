package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande5pRemiseAllemagne : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander 30 livres en Allemagne") {
        given("un panier de 30 livres à 10€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 10.0), 30)

            When("je calcule le total avec remise de 5%") {
                val total = panier.total

                Then("le total TTC est de 329.46€") {
                    total shouldBeExactly 329.46
                }
            }
        }

        given("un panier de 30 livres à 9.90€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 9.90), 30)

            When("je calcule le total avec remise de 5%") {
                val total = panier.total

                Then("le total TTC est de 326.17€") {
                    total shouldBeExactly 326.17
                }
            }
        }

        given("un panier de 10 livres à 19.99€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 19.99), 15)

            When("je calcule le total avec remise de 5%") {
                val total = panier.total

                Then("le total TTC est de 329.3€") {
                    total shouldBeExactly 329.3
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
