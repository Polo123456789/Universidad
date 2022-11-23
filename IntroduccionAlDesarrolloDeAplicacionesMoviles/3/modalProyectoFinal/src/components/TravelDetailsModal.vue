<template>
    <ion-content class="ion-padding">
        <ion-header>
            <ion-toolbar>
                <img src="https://st.depositphotos.com/1003256/3691/i/600/depositphotos_36914575-stock-photo-truck.jpg"
                    class="header-image" slot="start" />
                <ion-title>19/11/2022</ion-title>
            </ion-toolbar>
        </ion-header>
        <h1 class="title">{{placa}}</h1>
        <div class="content">
            <div class="section">
                <p>Foto frontal</p>
                <img
                    src="https://st.depositphotos.com/1003256/3691/i/600/depositphotos_36914575-stock-photo-truck.jpg" />
            </div>
            <div class="section">
                <p>Foto lateral</p>
                <img
                    src="https://previews.123rf.com/images/deusexlupus/deusexlupus1710/deusexlupus171000020/87400967-cami%C3%B3n-de-transporte-pesado-moderno-rojo-vista-lateral.jpg" />
            </div>
            <div class="section">
                <p>Foto del kilometraje</p>
                <img
                    src="https://www.fuso.com.pe/blog/wp-content/uploads/2019/08/fuso-odometro-importancia-en-camiones.jpg" />
            </div>
            <div class="section">
                <p>Foto de las llantas</p>
                <img src="https://i1.sndcdn.com/artworks-000389579193-c0frco-t500x500.jpg" />
            </div>
            <div class="section">
                <p>Foto de desperectos</p>
                <img
                    src="https://media.airedesantafe.com.ar/p/642da3fd1dde483e4e9ec165d721eeee/adjuntos/268/imagenes/003/386/0003386718/accidente-ruta-19jpg.jpg" />
            </div>
        </div>

        <div class="close" @click="close">X</div>
    </ion-content>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

import {
    IonContent,
    IonHeader,
    IonTitle,
    IonToolbar,
    modalController,
} from '@ionic/vue';

export default defineComponent({
    components: {
        IonContent,
        IonHeader,
        IonTitle,
        IonToolbar,
    },
    props: {
        placa: String,
    },
    methods: {
        close() {
            return modalController.dismiss(null, "close");
        }
    }
});
</script>

<style scoped>
.header-image {
    height: 48px;
    border-radius: 10px;
    margin: 5px;
}

.close {
    color: red;
    font-weight: 200;
    font-size:  larger;
    text-align: center;
    margin: 20px;
    padding: 5px;
}

.content {
    text-align: center;
}

.title {
    text-align: center;
}

.content>.section {
    margin-top: 20px;
}

.content>.section>img {
    border-radius: 15px;
}
</style>