class Publisher {
    constructor() {
        this.id = "";
        this.name = "";
        this.cat = [];
        this.domain = "";
    }
}

class Producer {
    constructor() {
        this.id = "";
        this.name = "";
        this.cat = [];
        this.domain = "";
    }
}

class Regs {
    constructor() {
        this.id = -1;
    }
}

class Segment {
    constructor() {
        this.id = "";
        this.name = "";
        this.value = "";
    }
}

class Content {
    constructor() {
        this.id = "";
        this.episode = -1;
        this.title = "";
        this.series = "";
        this.season = "";
        this.artist = "";
        this.genre = "";
        this.album = "";
        this.isrc = "";
        this.producer = new Producer();
        this.url = "";
        this.cat = [];
        this.prodq = -1;
        this.videoquality = -1;
        this.context = -1;
        this.contentrating = "";
        this.userrating = "";
        this.qagmediarating = -1;
        this.keywords = "";
        this.livestream = -1;
        this.sourcerelationship = -1;
        this.len = -1;
        this.language = "";
        this.embeddable = -1;
        this.data = [];
    }
}

class App {
    constructor() {
        this.id = "";
        this.name = "";
        this.bundle = "";
        this.domain = "";
        this.storeurl = "";
        this.cat = [];
        this.sectioncat = [];
        this.pagecat = [];
        this.ver = "";
        this.privacypolicy = -1;
        this.paid = -1;
        this.publisher = new Publisher();
        this.content = new Content();
        this.keywords = "";
    }
}

class Audio {
    constructor() {
        this.mimes = [];
        this.minduration = -1;
        this.maxduration = -1;
        this.protocols = [];
        this.startdelay = -1;
        this.sequence = -1;
        this.battr = [];
        this.maxextended = -1;
        this.minbitrate = -1;
        this.maxbitrate = -1;
        this.delivery = [];
        this.companionad = [];
        this.api = [];
        this.companiontype = [];
        this.maxseq = -1;
        this.feed = -1;
        this.stitched = -1;
        this.nvol = -1;
    }
}

class Banner {
    constructor() {
        this.format = [];
        this.w = -1;
        this.h = -1;
        this.wmax = -1;
        this.hmax = -1;
        this.wmin = -1;
        this.hmin = -1;
        this.btype = [];
        this.battr = [];
        this.pos = -1;
        this.mimes = [];
        this.topframe = -1;
        this.expdir = [];
        this.api = [];
        this.id = "";
        this.vcm = -1;
    }
}

class Data {
    constructor() {
        this.id = "";
        this.name = "";
        this.segment = [];
    }
}

class Deal {
    constructor() {
        this.id = "";
        this.bidfloor = 0;
        this.bidfloorcur = "USD";
        this.at = -1;
        this.wseat = [];
        this.wadomain = [];
    }
}

class Geo {
    constructor() {
        this.lat = 0.0;
        this.lon = 0.0;
        this.type = -1;
        this.accuracy = -1;
        this.lastfix = -1;
        this.ipservice = -1;
        this.country = "";
        this.region = "";
        this.regionfips104 = "";
        this.metro = "";
        this.city = "";
        this.zip = "";
        this.utcoffset = -1;
    }
}

class Device {
    constructor() {
        this.ua = "";
        this.geo = new Geo();
        this.dnt = -1;
        this.lmt = -1;
        this.ip = "";
        this.ipv6 = "";
        this.devicetype = -1;
        this.make = "";
        this.model = "";
        this.os = "";
        this.osv = "";
        this.hwv = "";
        this.h = -1;
        this.w = -1;
        this.ppi = -1;
        this.pxratio = 0.0;
        this.js = -1;
        this.geofetch = -1;
        this.flashver = "";
        this.language = "";
        this.carrier = "";
        this.mccmnc = "";
        this.connectiontype = -1;
        this.ifa = "";
        this.didsha1 = "";
        this.didmd5 = "";
        this.dpidsha1 = "";
        this.dpidmd5 = "";
        this.macsha1 = "";
        this.macmd5 = "";
    }
}

class Format {
    constructor() {
        this.w = -1;
        this.h = -1;
        this.wratio = -1;
        this.hratio = -1;
        this.wmin = -1;
    }
}

class Metric {
    constructor() {
        this.type = "";
        this.value = 0.0;
        this.vendor = "";
    }
}

class Native {
    constructor() {
        this.request = "";
        this.ver = "";
        this.api = [];
        this.battr = [];
    }
}

class Pmp {
    constructor() {
        this.private_auction = 0;
        this.deals = [];
    }
}

class Site {
    constructor() {
        this.id = "";
        this.name = "";
        this.domain = "";
        this.cat = [];
        this.sectioncat = [];
        this.pagecat = [];
        this.page = "";
        this.ref = "";
        this.search = "";
        this.mobile = -1;
        this.privacypolicy = -1;
        this.publisher = new Publisher();
        this.content = new Content();
        this.keywords = "";
    }
}

class Source {
    constructor() {
        this.fd = -1;
        this.tid = "";
        this.pchain = "";
    }
}

class User {
    constructor() {
        this.id = "";
        this.buyeruid = "";
        this.yob = -1;
        this.gender = "";
        this.keywords = "";
        this.customdata = "";
        this.geo = new Geo();
        this.data = [];
    }
}

class Video {
    constructor() {
        this.mimes = [];
        this.minduration = -1;
        this.maxduration = -1;
        this.protocols = [];
        this.protocol = -1;
        this.w = -1;
        this.h = -1;
        this.startdelay = -1;
        this.placement = -1;
        this.linearity = -1;
        this.skip = -1;
        this.skipmin = 0;
        this.skipafter = 0;
        this.sequence = -1;
        this.battr = [];
        this.maxextended = -1;
        this.minbitrate = -1;
        this.maxbitrate = -1;
        this.boxingallowed = 1;
        this.playbackmethod = [];
        this.playbackend = -1;
        this.delivery = [];
        this.pos = -1;
        this.companionad = [];
        this.api = [];
        this.companiontype = [];
    }
}

class Imp {
    constructor() {
        this.id = "";
        this.metric = [];
        this.banner = new Banner();
        this.video = new Video();
        this.audio = new Audio();
        this.native = new Native();
        this.pmp = new Pmp();
        this.displaymanager = "";
        this.displaymanagerver = "";
        this.instl = 0;
        this.tagid = "";
        this.bidfloor = 0.0;
        this.bidfloorcur = "USD";
        this.clickbrowser = -1;
        this.secure = -1;
        this.iframebuster = [];
        this.exp = -1;
    }
}

class BidRequest {
    constructor() {
        this.id = "";
        this.imp = [];
        this.site = new Site();
        this.app = new App();
        this.device = new Device();
        this.user = new User();
        this.test = 0;
        this.at = 2;
        this.tmax = -1;
        this.wseat = [];
        this.bseat = [];
        this.allimps = 0;
        this.cur = [];
        this.wlang = [];
        this.bcat = [];
        this.badv = [];
        this.bapp = [];
        this.source = new Source();
        this.regs = new Regs();
    }
}