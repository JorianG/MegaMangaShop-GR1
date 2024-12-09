package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID;


data class TicketDeCaisse(val id: String = ULID().nextULID()) {
    val totalTtc: Double = 0.0
    val taxe: Double = 0.0
    val remise: Double = 0.0
}
