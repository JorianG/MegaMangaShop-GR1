package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande3pRemiseBelgique : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander 20 livres en Belgique") {
        given("un panier de 20 livres à 10€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 10.0), 20)

            When("je calcule le total avec remise de 3%") {
                val total = panier.total

                Then("le total TTC est de 226.98€") {
                    total shouldBeExactly 226.98
                }
            }
        }

        given("un panier de 20 livres à 9.90€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 9.90), 20)

            When("je calcule le total avec remise de 3%") {
                val total = panier.total

                Then("le total TTC est de 224.71€") {
                    total shouldBeExactly 224.71
                }
            }
        }

        given("un panier de 10 livres à 19.99€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 19.99), 10)

            When("je calcule le total avec remise de 3%") {
                val total = panier.total

                Then("le total TTC est de 226.87€") {
                    total shouldBeExactly 226.87
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
