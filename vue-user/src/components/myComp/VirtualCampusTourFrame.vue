<template>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="subscribe-wrapper_1 text-center p-0">

                    <div style="height: 500px; width: 100%">
                        <div id="map"></div>
                        <div id="pano"></div>
                        <div id="map-satellite"></div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'VirtualCampusTour',
        props:{

        },
        data(){
            return{

            }
        },
        created() {
            this.initMap();
        },
        methods:{
            initMap() {
                function initialize() {
                    // const fenway = { lat: 42.345573, lng: -71.098326 };
                    const fenway = { lat: 40.807384, lng: -73.963036 };
                    // const duke = { lat: 36.0014, lng: -78.939133 };
                    let mapOptions = {
                        zoom: 16,
                        center: fenway
                    };
                    let mapOptionsSatellite = {
                        zoom: 16,
                        center: fenway,
                        mapTypeId: 'satellite'
                    };
                    const map = new google.maps.Map(document.getElementById("map"), mapOptions);
                    const panorama = new google.maps.StreetViewPanorama(
                        document.getElementById("pano"),
                        {
                            position: fenway,
                            pov: {
                                heading: 34,
                                pitch: 10,
                            },
                        }
                    );
                    map.setStreetView(panorama);

                    const mapSatellite = new google.maps.Map(document.getElementById("map-satellite"), mapOptionsSatellite);
                    mapSatellite.setStreetView(panorama);
                }
                window.initialize = initialize;
            },

        }
    }
</script>

<style>
#map{
    float: left;
    height: 100%;
    width: 20%;
}

#pano{
    float: left;
    height: 100%;
    width: 60%;
}

#map-satellite{
    float: left;
    height: 100%;
    width: 20%;
}

</style>
