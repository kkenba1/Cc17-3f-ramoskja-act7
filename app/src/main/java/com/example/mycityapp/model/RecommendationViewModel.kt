package com.example.mycityapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycityapp.R

class RecommendationViewModel : ViewModel() {

    private val _recommendations = MutableLiveData<List<Recommendation>>()
    val recommendations: LiveData<List<Recommendation>> = _recommendations
    fun loadRecommendations(category: String) {
        val sampleData = when (category) {
            "Hotels" -> listOf(
                Recommendation(
                    "Lisland Rainforest Resort",
                    "Lisland Rainforest Resort is a paradise within the city with a 1,500 sq. meter main swimming pool, with a 150 sq. meter childrens wading pool. It has a 200 sitting capacity bar and restaurant, conference hall, a pavilion and picnic and garden area. Lisland caters to wedding ceremonies and receptions, conferences, seminars, business meetings and parties. It has 32 air-conditioned rooms with private toilet and bath, with hot and cold showers, TV and WIFI.",
                   R.drawable.lisland_rainforest_resort,
                ),
                Recommendation(
                    "Sarojus FarmView Hotel",
                    "Sarojus Farmview Hotel, where a serene atmosphere meets farm-to-table cuisine. Savor the local flavors at breakfast and enjoy free daily manager's reception. Relax by the pool, unwind in the sauna or steam room, and breathe in fresh air on the garden terrace.",
                    R.drawable.saroju
                ),
                Recommendation(
                    "Majoha Hotel",
                    "Majoha Hotel puts the best of Urdaneta City at your fingertips, making your stay both relaxing and enjoyable. ",
                    R.drawable.majoha_hotel
                ),
                Recommendation(
                    "Levo Hotel",
                    "Levo Hotel is located in Urdaneta, 21 miles from Sunflower Maze. With free WiFi, this 3-star hotel offers room service and a 24-hour front desk. There's a restaurant serving Chinese cuisine, and free private parking is available.",
                    R.drawable.levo
                )
            )
            "Restaurants" -> listOf(
                Recommendation(
                    "Matutina Gerry's Seafood House",
                    " Come and feast in one of the finest seafood dining experiences in the country. Indulge yourself in an unforgettable delightful meal and relax in Matutina's cozy ambiance of home ",
                    R.drawable.matutina
                ),
                Recommendation(
                    "Urban District",
                    "Urban District is located in Urdaneta, than can give you mouthwatering foods and can also give you the best experience in terms of ambiance and customer service. ",
                    R.drawable.urban_district
                ),
                Recommendation(
                    "Cuisinero",
                    "Cuisinero serves delicious thick and juicy steaks imported from Australia and the USA, fabulous pastas, and dishes from Mozambique, Italy, the UK ",
                    R.drawable.cuisinero
                ),
                Recommendation(
                    "Dampa sa Pangasinan",
                    "Dampa offers a variety of sea foods that will bring you to the sea itself!.",
                    R.drawable.dampa
                )
            )
            "Grocery Centers" -> listOf(
                Recommendation(
                    "SM Urdaneta",
                    "SM Urdaneta Central has a well-organized and spacious grocery section located inside the SM Hypermarket. It offers a wide variety of fresh produce, meats, seafood, and pantry staples. Known for its affordability and regular promotions, this grocery caters to both budget-conscious shoppers and those looking for premium imported items.",
                    R.drawable.sm_urd
                ),
                Recommendation(
                    "Cb Mall",
                    "The grocery section in CB Mall, typically operated by SaveMore, is smaller but efficiently arranged. It offers all the essentials, including fresh produce, meats, frozen goods, and snacks. Its central location in Urdaneta makes it a go-to for quick grocery runs.",
                    R.drawable.cb
                ),
                Recommendation(
                    "Magic Mall",
                    "The Magic Mall grocery, typically part of the Magic Supermarket chain, is known for being budget-friendly and catering to the daily needs of local shoppers. It provides fresh produce, basic household items, and an assortment of snacks and beverages.",
                    R.drawable.magic_mall_urdaneta_city
                ),
                Recommendation(
                    "Puregold",
                    "Puregold is known for catering to bulk buyers and small business owners. Located near the city center, it offers a wide range of wholesale and retail grocery items, including fresh goods, canned products, and dry goods.",
                    R.drawable.puregold
                )
            )

            else -> emptyList()
        }
        _recommendations.value = sampleData
    }
}
