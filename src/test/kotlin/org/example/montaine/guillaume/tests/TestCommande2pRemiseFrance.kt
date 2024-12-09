
package org.example.montaine.guillaume.tests

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.doubles.shouldBeExactly
import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

class TestCommande2pRemiseFrance: BehaviorSpec({

    context("En tant que vendeur, je souhaite commander entre 151€ et 200€ livres en France"){
        given("un panier de 16 livres à 10€"){
            val panier = Panier(Pays.FRANCE);
            panier.ajouterManga(Manga("test", 10.0),16)


            When("je calcule le total avec 20% de taxes et 2% de remises"){
                val total = panier.total

                Then("le total TTC est de 188.16€") {
                    total shouldBeExactly 188.16
                }
            }

        }

        given("un panier de 16 livres à 9.90€"){
            val panier = Panier(Pays.FRANCE)
            panier.ajouterManga(Manga("test", 9.90),16)


            When("je calcule le total avec 20% de taxes et 2% de remises" ){
                val total = panier.total

                Then("le total TTC est de 186.28€"){
                    total shouldBeExactly 186.28
                }
            }
        }

        given("une quantité négative de livres"){
            val panier = Panier(Pays.FRANCE);

            Then("une exception IllegalArgument est levée "){
                shouldThrow<IllegalArgumentException> { panier.ajouterManga(Manga("test", 10.0),-100) }
            }

        }
    }
})