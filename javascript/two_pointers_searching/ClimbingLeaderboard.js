'use strict'

/**
 * An arcade game player wants to climb to the top of the leaderboard and track their ranking. The game uses Dense
 * Ranking, so its leaderboard works like this:
 * - The player with the highest score is ranked number 1 on the leaderboard.
 * - Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately
 * following ranking number.
 *
 * Example:
 * ranked = [100, 90, 90, 80]
 * player = [70, 80, 105]
 *
 * The ranked players will have ranks 1, 2, 2 and 3, respectively. If the player's scores are 70, 80 and 105, their
 * rankings after each game are 4th, 3rd, and 1st. Return [4,3,1].
 * See <a href="https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem">
 * Hackerrank - Climbing the Leaderboard
 */
const climbingLeaderboard = (ranked,player) => {
    const rankedUnique = [...new Set(ranked)]
    const results = []
    let i = rankedUnique.length - 1

    for(const score of player ) {
        while(i >= 0 && score >= rankedUnique[i]) {
            i--
        }
        results.push(i+2)
    }

    console.log(results)
}


let ranked = [100, 100, 50, 40, 40, 20, 10]
// let player = [10, 4, 7, 6]
// let player = [5, 25, 50, 120]
let player = [50, 65, 77, 90, 102]

climbingLeaderboard(ranked,player)