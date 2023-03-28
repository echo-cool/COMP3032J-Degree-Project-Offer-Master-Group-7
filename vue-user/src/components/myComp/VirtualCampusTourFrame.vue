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

    import {Loader} from "@googlemaps/js-api-loader";

    const loader = new Loader({
        apiKey: "AIzaSyDJ7ELJuZaigtiB50_buOhvcjyGvOTk5MY",
        version: "weekly",
    });

    export default {
        name: 'VirtualCampusTour',
        props:{

        },
        data(){
            return{

            }
        },
        created() {

        },
        mounted() {

        },
        methods:{
            // this should be called by the parent comp out of this comp
            initMap(lat, lng){
                // the coordinate to show
                let coords = {lat, lng};

                // the options for all the maps and street views
                let mapOptions = {
                    zoom: 14,
                    center: coords
                };
                let panoramaOptions = {
                    position: coords,
                    pov: {
                        heading: 34,
                        pitch: 10,
                    }
                };
                let mapOptionsSatellite = {
                    zoom: 14,
                    center: coords,
                    mapTypeId: 'satellite'
                };

                // load that 2 maps and a 3D street view
                loader.load().then(async () => {
                    // import Map and StreetViewPanorama constructor
                    const { Map } = await google.maps.importLibrary("maps");
                    const { StreetViewPanorama } = await google.maps.importLibrary("streetView");

                    // create the instance of 2 maps (normal and satellite) and a street view
                    const map = new Map(document.getElementById("map"), mapOptions);
                    const panorama = new StreetViewPanorama(document.getElementById("pano"), panoramaOptions)
                    const mapSatellite = new Map(document.getElementById("map-satellite"), mapOptionsSatellite);

                    // bind the map with the street view
                    mapSatellite.setStreetView(panorama);
                    map.setStreetView(panorama);
                });
            }
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
