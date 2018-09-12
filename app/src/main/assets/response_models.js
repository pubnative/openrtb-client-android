class Bid {
    constructor() {
        this.id = "";
        this.impid = "";
        this.price = 0.0;
        this.nurl = "";
        this.burl = "";
        this.lurl = "";
        this.adm = "";
        this.adid = "";
        this.adomain = [];
        this.bundle = "";
        this.iurl = "";
        this.cid = "";
        this.crid = "";
        this.tactic = "";
        this.cat = [];
        this.attr = [];
        this.api = -1;
        this.protocol = -1;
        this.qagmediarating = -1;
        this.language = "";
        this.dealid = "";
        this.w = -1;
        this.h = -1;
        this.wratio = -1;
        this.hratio = -1;
        this.exp = -1;
    }
}

class SeatBid {
    constructor() {
        this.bid = [];
        this.seat = "";
        this.group = 0;
    }
}

class BidResponse {
    constructor() {
        this.id = "";
        this.seatbid = [];
        this.bidid = "";
        this.cur = "USD";
        this.customdata = "";
        this.nbr = -1;
    }
}