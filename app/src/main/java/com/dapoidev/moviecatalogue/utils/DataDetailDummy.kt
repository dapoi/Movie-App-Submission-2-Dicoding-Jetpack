package com.dapoidev.moviecatalogue.utils

import com.dapoidev.moviecatalogue.model.data.entity.DetailEntity
import com.dapoidev.moviecatalogue.model.data.remote.response.GenreResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MoviesDetailResponse
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowsDetailResponse

object DataDetailDummy {

    fun getDetailMovie(): DetailEntity {
        return DetailEntity(
            399566,
            "Godzilla vs. Kong",
            "2021-03-24",
            listOf("Science Fiction", "Action"),
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."
        )
    }

    fun getDetailTVShow(): DetailEntity {
        return DetailEntity(
            60735,
            "The Flash",
            "2014-10-07",
            listOf("Drama", "Sci-Fi & Fantasy"),
            "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        )
    }

    fun getRemoteDetailMovie(): MoviesDetailResponse {
        return MoviesDetailResponse(
            id = 399566,
            title = "Godzilla vs. Kong",
            date = "2021-03-24",
            genres = listOf(
                GenreResponse(
                    id = 878,
                    name = "Science Fiction"
                ),
                GenreResponse(
                    id = 28,
                    name = "Action"
                )
            ),
            imageDetail = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            desc = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."
        )
    }

    fun getRemoteDetailTVShow(): TVShowsDetailResponse {
        return TVShowsDetailResponse(
            id = 60735,
            title = "The Flash",
            date = "2014-10-07",
            listOf(
                GenreResponse(
                    id = 18,
                    name = "Drama"
                ),
                GenreResponse(
                    id = 10765,
                    name = "Sci-Fi & Fantasy"
                )
            ),
            imageDetail = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            desc = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
        )
    }
}