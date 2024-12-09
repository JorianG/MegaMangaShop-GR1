package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommandeEspagne : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander des livres en Espagne") {
        given("un panier de 5 livres à 10€") {
            val panier = Panier(Pays.ESPAGNE)

            panier.ajouterManga(Manga("test", 10.0), 5)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 59.1€") {
                    total shouldBeExactly 59.1
                }
            }
        }

        given("un panier de 3 livres à 20€") {
            val panier = Panier(Pays.ESPAGNE)

            panier.ajouterManga(Manga("test", 20.0), 3)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 70.92€") {
                    total shouldBeExactly 70.92
                }
            }
        }

        given("un panier de 3 livres à 9.90€") {
            val panier = Panier(Pays.ESPAGNE)

            panier.ajouterManga(Manga("test", 9.90), 3)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 35.11€") {
                    total shouldBeExactly 35.11
                }
            }
        }

        given("un panier de 2 livres à 15.50€") {
            val panier = Panier(Pays.ESPAGNE)

            panier.ajouterManga(Manga("test", 15.50), 2)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 36.64€") {
                    total shouldBeExactly 36.64
                }
            }
        }

        given("un panier de 7 livres à 19.99€") {
            val panier = Panier(Pays.ESPAGNE)

            panier.ajouterManga(Manga("test", 19.99), 7)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 165.40€") {
                    total shouldBeExactly 165.40
                }
            }
        }

        given("un livre à -10€") {

            Then("une exception IllegalArgument est levée ") {
                shouldThrow<IllegalArgumentException> { Manga("test", -10.0) }
            }
        }

        given("une livre à 4.999€"){
            Then("une exception IllegalArgument est levée "){
                shouldThrow<IllegalArgumentException> { Manga("test", 4.999) }
            }
        }
    }
})
