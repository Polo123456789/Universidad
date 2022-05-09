@isset($username)
    @include('header', [
        'title' => 'Hola mundo',
        'username' => $username
    ])
@else
    @include('header', ['title' => 'Hola mundo'])
@endif

<main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
            <div class="col-lg-6 col-md-8 mx-auto">
                <h1 class="fw-light">Supermercado X</h1>
                <p class="lead text-muted">
                    Donde encuentra los mejores productos, a los mejores precios
                </p>
                <p>
                    <a href="#productos" class="btn btn-primary my-2">Ver nuestros productos</a>
                </p>
            </div>
        </div>
    </section>

    <div class="album py-5 bg-light" id="productos">
        <div class="container">
    
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/apple.jpg')}}" alt="Manzana" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Deliciosas Manzanas
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/banana.jpg')}}" alt="Banana" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Nutritivas Bananas
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/aguacate.jpg')}}" alt="Aguacate" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Aguacates en su punto
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/fresa.jpg')}}" alt="Fresas" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Dulces Fresas
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/limon.jpg')}}" alt="Limones" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Limones del árbol a su mesa
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/arandano.jpg')}}" alt="Arandanos" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Abundantes Arándanos
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/carne.jpg')}}" alt="Carnes" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Una lista entera de cortes a su elección
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/cereal.jpg')}}" alt="Cereales" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Una coleccion de cereales para desayunar
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col">
                    <div class="card shadow-sm">
                        <img src="{{URL::asset('img/pescado.jpg')}}" alt="Pescado" class="img-card-top">
                        <div class="card-body">
                            <p class="card-text text-center">
                                Una seleccion de los mas finos pescados
                            </p>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</main>

@include('footer')
