package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande201LivresBelgique : BehaviorSpec({
    context("En tant que vendeur, je souhaite commander 201 livres en Belgique") {
        given("un panier de 201 livres à 10€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 10.0), 201)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 2281.15€") {
                    total shouldBeExactly 2281.15
                }
            }
        }

        given("un panier de 201 livres à 9.90€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 9.90), 201)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 2258.34€") {
                    total shouldBeExactly 2258.34
                }
            }
        }

        given("un panier de 201 livres à 19.99€") {
            val panier = Panier(Pays.BELGIQUE)

            panier.ajouterManga(Manga("test", 19.99), 201)

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 4560.02€") {
                    total shouldBeExactly 4560.02
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
