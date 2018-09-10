# OpenRTB client #

This sample application contains a prototype of an OpenRTB client according to the [OpenRTB v2.5](https://www.iab.com/wp-content/uploads/2016/03/OpenRTB-API-Specification-Version-2-5-FINAL.pdf) specification.

##Current features

* Make bid requests to PubNative exchange API
* Do the auction process (simple auction, the one with higher price wins)
* Process auction price macros on URLs and creatives markup
* Render creative received on winning bid
* Report win and loss notice through URLs

##Missing features

* Dynamically fill all values from the BidRequest object (currently many of them are hardcoded)
* Enhance the auction logic to something similar to what occurs on the server side
* Support all formats on the demo app. Currently only format in the demo is Standard MRect