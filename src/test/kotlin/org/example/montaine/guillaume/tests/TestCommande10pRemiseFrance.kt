package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande10pRemiseFrance : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander 30 livres en France") {
        given("un panier de 30 livres à 10€") {
            val panier = Panier(Pays.FRANCE)

            panier.ajouterManga(Manga("test", 10.0), 1506)

            When("je calcule le total avec remise de 10%") {
                val total = panier.total

                Then("le total TTC est de 16264.8€") {
                    total shouldBeExactly 16264.8
                }
            }
        }

        given("un panier de 30 livres à 9.90€") {
            val panier = Panier(Pays.FRANCE)

            panier.ajouterManga(Manga("test", 9.90), 1506)

            When("je calcule le total avec remise de 10%") {
                val total = panier.total

                Then("le total TTC est de 16102.15€") {
                    total shouldBeExactly 16102.15
                }
            }
        }

        given("un panier de 10 livres à 19.99€") {
            val panier = Panier(Pays.FRANCE)

            panier.ajouterManga(Manga("test", 19.99), 1506)

            When("je calcule le total avec remise de 10%") {
                val total = panier.total

                Then("le total TTC est de 32513.3352€") {
                    total shouldBeExactly 32513.34
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
