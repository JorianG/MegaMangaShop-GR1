package org.example.montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

fun main() {
    val panier1 = Panier(Pays.ESPAGNE)
    panier1.ajouterManga(Manga("Manga1", 3.99), 19)

    println("Total panier1: ${panier1.total}")

    val panier2 = Panier(Pays.FRANCE)
    panier2.ajouterManga(Manga("Manga2", 3.92), 42)
    panier2.ajouterManga(Manga("Manga3", 4.1), 82)
    panier2.ajouterManga(Manga("Manga4", 18.95), 12)

    println("Total panier2: ${panier2.total}")
}
