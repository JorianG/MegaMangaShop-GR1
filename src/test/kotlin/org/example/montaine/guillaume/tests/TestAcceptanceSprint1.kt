package org.example.montaine.guillaume.tests

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestAcceptanceSprint1: BehaviorSpec ({
    context("En tant que vendeur, je souhaite commander des livres en France") {
        given("un panier de 19 mangas à 3.99€") {
            val panier = Panier(Pays.FRANCE);
            repeat(19) {
                panier.ajouterManga(Manga("1", "test", 3.99))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 90.97€") {
                    total shouldBeExactly 90.97
                }
            }

        }

        given("un panier de 42 mangas à 3.92€ et 82 mangas à 4.1€") {
            val panier = Panier(Pays.FRANCE);
            repeat(42) {
                panier.ajouterManga(Manga("1", "test", 3.92))
            }
            repeat(82) {
                panier.ajouterManga(Manga("2", "test2", 4.1))
            }

            When("je calcule le total") {
                val total = panier.total

                Then("le total TTC est de 601.01€") {
                    total shouldBeExactly 601.01
                }
            }

        }
    }
})