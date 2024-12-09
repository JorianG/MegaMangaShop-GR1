package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommandeRoyaumeUni : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander des livres au Royaume-Uni") {
        given("un panier de 5 livres à 10€") {
            val panier = Panier(Pays.ROYAUME_UNI);
            repeat(5) {
                panier.ajouterManga(Manga("1", "test", 10.0))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 61.4€") {
                    total shouldBeExactly 61.4
                }
            }
        }

        given("un panier de 3 livres à 20€") {
            val panier = Panier(Pays.ROYAUME_UNI);
            repeat(3) {
                panier.ajouterManga(Manga("1", "test", 20.0))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 73.68€") {
                    total shouldBeExactly 73.68
                }
            }
        }

        given("un panier de 3 livres à 9.90€") {
            val panier = Panier(Pays.ROYAUME_UNI);
            repeat(3) {
                panier.ajouterManga(Manga("1", "test", 9.90))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 36.47€") {
                    total shouldBeExactly 36.47
                }
            }
        }

        given("un panier de 2 livres à 15.50€") {
            val panier = Panier(Pays.ROYAUME_UNI);
            repeat(2) {
                panier.ajouterManga(Manga("1", "test", 15.50))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 38.07€") {
                    total shouldBeExactly 38.07
                }
            }
        }

        given("un panier de 7 livres à 19.99€") {
            val panier = Panier(Pays.ROYAUME_UNI);
            repeat(7) {
                panier.ajouterManga(Manga("1", "test", 19.99))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 171.83€") {
                    total shouldBeExactly 171.83
                }
            }
        }

        given("un livre à -10€") {
            Then("une exception IllegalArgument est levée ") {
                shouldThrow<IllegalArgumentException> { Manga("1", "test", -10.0) }
            }
        }
    }
})