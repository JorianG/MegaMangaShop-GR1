package org.example.montaine.guillaume.montaine.guillaume

import kotlin.math.round

class Panier(val pays: Pays) {
    private val mangas = mutableListOf<Manga>()

    fun ajouterManga(manga: Manga, quantity: Int = 1) = repeat(quantity) { mangas.add(manga) }

    fun retirerManga(manga: Manga, quantity: Int = 1) = repeat(quantity) { mangas.remove(manga) }

    val total: Double
        get() {
            val total = mangas.sumOf { it.prix }
            val withTax = total * (1 + pays.taxe)
            return round(withTax * 100) / 100
        }
}
