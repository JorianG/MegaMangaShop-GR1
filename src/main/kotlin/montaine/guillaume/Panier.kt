package org.example.montaine.guillaume.montaine.guillaume

import kotlin.math.round

class Panier(val pays: Pays) {
    private val mangas = mutableListOf<Manga>()

    fun ajouterManga(manga: Manga, quantity: Int = 1) {
        if (quantity < 1) throw IllegalArgumentException("La quantité doit être supérieure à 0")
        repeat(quantity) { mangas.add(manga) }
    }

    fun retirerManga(manga: Manga, quantity: Int = 1) {
        if (quantity < 1) throw IllegalArgumentException("La quantité doit être supérieure à 0")
        repeat(quantity) { mangas.remove(manga) }
    }

    val total: Double
        get() {
            val total = mangas.sumOf { it.prix }
            val withTax = total * (1 + pays.taxe)
            val withReduc = when {
                withTax <= 150 -> withTax
                withTax <= 200 -> withTax * 0.98
                withTax <= 300 -> withTax * 0.97
                withTax <= 500 -> withTax * 0.95
                withTax <= 1000 -> withTax * 0.93
                else -> withTax * 0.90
            }
            return round(withReduc * 100) / 100
        }
}
