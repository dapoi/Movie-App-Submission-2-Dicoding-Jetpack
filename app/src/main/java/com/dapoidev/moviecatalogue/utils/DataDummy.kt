package com.dapoidev.moviecatalogue.utils

import com.dapoidev.moviecatalogue.model.data.entity.MovieEntity
import com.dapoidev.moviecatalogue.model.data.entity.TVShowEntity
import com.dapoidev.moviecatalogue.model.data.remote.response.movie.MovieRemote
import com.dapoidev.moviecatalogue.model.data.remote.response.tvshow.TVShowRemote

object DataDummy {
    fun getMovies(): ArrayList<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                460465,
                "Mortal Kombat",
                "2021-04-07",
                "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
            )
        )

        movies.add(
            MovieEntity(
                399566,
                "Godzilla vs. Kong",
                "2021-03-24",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."
            )
        )

        movies.add(
            MovieEntity(
                615457,
                "Nobody",
                "2021-03-24",
                "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind."
            )
        )

        movies.add(
            MovieEntity(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions."
            )
        )

        movies.add(
            MovieEntity(
                632357,
                "The Unholy",
                "2021-03-31",
                "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister."
            )
        )
        return movies
    }


    fun getTVShows(): ArrayList<TVShowEntity> {

        val tvShows = ArrayList<TVShowEntity>()

        tvShows.add(
            TVShowEntity(
                88396,
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShows.add(
            TVShowEntity(
                71712,
                "The Good Doctor",
                "2017-09-25",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        tvShows.add(
            TVShowEntity(
                79008,
                "Luis Miguel: The Series",
                "2018-04-22",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
            )
        )

        tvShows.add(
            TVShowEntity(
                60735,
                "The Flash",
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShows.add(
            TVShowEntity(
                65820,
                "Van Helsing",
                "2016-09-23",
                "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg"
            )
        )

        return tvShows
    }


    fun getRemoteMovies(): ArrayList<MovieRemote> {

        val remoteMovie = ArrayList<MovieRemote>()

        remoteMovie.add(
            MovieRemote(
                id = 460465,
                title = "Mortal Kombat",
                date = "2021-04-07",
                image = "/6Wdl9N6dL0Hi0T1qJLWSz6gMLbd.jpg",
                desc = "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe."
            )
        )

        remoteMovie.add(
            MovieRemote(
                id = 399566,
                title = "Godzilla vs. Kong",
                date = "2021-03-24",
                image = "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                desc = "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages."
            )
        )

        remoteMovie.add(
            MovieRemote(
                id = 615457,
                title = "Nobody",
                date = "2021-03-24",
                image = "/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg",
                desc = "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \\\"nobody.\\\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind."
            )
        )

        remoteMovie.add(
            MovieRemote(
                791373,
                title = "Zack Snyder's Justice League",
                date = "2021-03-18",
                image = "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                desc = "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions."
            )
        )

        remoteMovie.add(
            MovieRemote(
                id = 632357,
                title = "The Unholy",
                date = "2021-03-31",
                image = "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
                desc = "Alice, a young hearing-impaired girl who, after a supposed visitation from the Virgin Mary, is inexplicably able to hear, speak and heal the sick. As word spreads and people from near and far flock to witness her miracles, a disgraced journalist hoping to revive his career visits the small New England town to investigate. When terrifying events begin to happen all around, he starts to question if these phenomena are the works of the Virgin Mary or something much more sinister."
            )
        )
        return remoteMovie
    }


    fun getRemoteTVShows(): ArrayList<TVShowRemote> {

        val tvShowRemote = ArrayList<TVShowRemote>()

        tvShowRemote.add(
            TVShowRemote(
                id = 88396,
                title = "The Falcon and the Winter Soldier",
                date = "2021-03-19",
                desc = "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                image = "/6kbAMLteGO8yyewYau6bJ683sw7.jpg"
            )
        )

        tvShowRemote.add(
            TVShowRemote(
                id = 71712,
                title = "The Good Doctor",
                date = "2017-09-25",
                desc = "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                image = "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        tvShowRemote.add(
            TVShowRemote(
                id = 79008,
                title = "Luis Miguel: The Series",
                date = "2018-04-22",
                desc = "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                image = "/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
            )
        )

        tvShowRemote.add(
            TVShowRemote(
                id = 60735,
                title = "The Flash",
                date = "2014-10-07",
                desc = "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                image = "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"
            )
        )

        tvShowRemote.add(
            TVShowRemote(
                id = 65820,
                title = "Van Helsing",
                date = "2016-09-23",
                desc = "Vanessa Helsing, the daughter of famous vampire hunter and Dracula nemesis Abraham Van Helsing is resurrected five years in the future to find out that vampires have taken over the world and that she possesses unique power over them. She is humanity’s last hope to lead an offensive to take back what has been lost.",
                image = "/r8ODGmfNbZQlNhiJl2xQENE2jsk.jpg"
            )
        )

        return tvShowRemote
    }
}