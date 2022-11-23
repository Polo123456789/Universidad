<template>
  <ion-page>
    <ion-header :translucent="true">
      <ion-toolbar>
        <ion-title>Modal para proyecto final</ion-title>
      </ion-toolbar>
    </ion-header>
    
    <ion-content class="ion-padding" :fullscreen="true">
      <div id="container">
        <ion-button expand="block" @click="openDetails">Abrir modal</ion-button>
      </div>
    </ion-content>
  </ion-page>
</template>

<script lang="ts">

import {
  IonContent,
  IonHeader,
  IonPage,
  IonTitle,
  IonToolbar,
  IonButton,
  modalController
} from '@ionic/vue';

import { defineComponent } from 'vue';

import TravelDetailsModal from '@/components/TravelDetailsModal.vue';

export default defineComponent({
  name: 'HomePage',
  components: {
    IonContent,
    IonHeader,
    IonPage,
    IonTitle,
    IonToolbar,
    IonButton,
  },
  methods: {
    async openDetails() {
      const modal = await modalController.create({
        component: TravelDetailsModal,
        componentProps: {
          placa: "C 0255REW"
        }
      });
      modal.present();

      const _ = await modal.onWillDismiss();
    }
  }
});
</script>

<style scoped>
  #container {
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>
