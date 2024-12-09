package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommandeAllemagne : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander des livres en ALLEMAGNE") {
        given("un panier de 5 livres à 10€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 10.0), 5)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 57.8€") {
                    total shouldBeExactly 57.8
                }
            }
        }

        given("un panier de 3 livres à 20€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 20.0), 3)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 69.36€") {
                    total shouldBeExactly 69.36
                }
            }
        }

        given("un panier de 3 livres à 9.90€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 9.90), 3)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 35.64€") {
                    total shouldBeExactly 34.33
                }
            }
        }

        given("un panier de 2 livres à 15.50€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 15.50), 2)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 35.84€") {
                    total shouldBeExactly 35.84
                }
            }
        }

        given("un panier de 7 livres à 19.99€") {
            val panier = Panier(Pays.ALLEMAGNE)

            panier.ajouterManga(Manga("test", 19.99), 7)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 161,76€") {
                    total shouldBeExactly 161.76
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
