package org.example.montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Manga
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.example.montaine.guillaume.montaine.guillaume.Pays

fun main() {
    val panier1 = Panier(Pays.FRANCE)
    repeat(19) {
        panier1.ajouterManga(Manga("1", "Manga1", 3.99))
    }
    println("Total panier1: ${panier1.total}")

    val panier2 = Panier(Pays.FRANCE)
    repeat(42) {
        panier2.ajouterManga(Manga("2", "Manga2", 3.92))
    }
    repeat(82) {
        panier2.ajouterManga(Manga("3", "Manga3", 4.1))
    }
    println("Total panier2: ${panier2.total}")
}
