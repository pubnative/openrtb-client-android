function calculateAuctionPrice(bid) {
    return bid.price;
}

function makeRequest(url) {
    /*const Data = {

    };

    const params = {
        headers: {

        },
        body: Data,
        method: "GET"
    };*/

    fetch(url).then(data => {
        return data.json();
    }).then(res => {
        console.log(res);
    }).catch(error => {
        console.log(error);
    });

}

function notifyWinner(winner, auctionPrice) {
    if (winner.nurl && winner.nurl !== "") {
        let winUrl = winner.nurl;
        makeRequest(winUrl);
    } else {
        console.log("Winning bid has no win notice URL. Dropping call");
    }
}

function notifyLosers(losers, auctionPrice) {
    if (losers) {
        for (let loser of losers) {
            if (loser.lurl && loser.lurl !== "") {
                let lossUrl = loser.lurl;
                makeRequest(lossUrl);
            } else {
                console.log("Winning bid has no loss notice URL. Dropping call");
            }
        }
    }
}

function performAuction(responses) {
    var winningBid = 0;
    var winner;
    let losers = [];

    for (let response of responses) {
        for (let seatBid of response.seatbid) {
            for (let bid of seatBid.bid) {
                if (bid.price > winningBid) {
                    winningBid = bid.price;

                    if (winner) {
                        losers.push(winner);
                    }

                    winner = bid;
                }
            }
        }
    }

    if (winner) {
        let auctionPrice = calculateAuctionPrice(winner);

        notifyWinner(winner, auctionPrice);
        notifyLosers(losers, auctionPrice);
    }
}