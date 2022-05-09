@isset($username)
    @include('header', [
        'title' => 'Hola mundo',
        'username' => $username
    ])
@else
    @include('header', ['title' => 'Hola mundo'])
@endif

<main>
    <div class="container">
        <div class="w-100 d-flex justify-content-center">
            <img src="{{URL::asset('img/line-graph.webp')}}" alt="Grafica" class="mx-auto">
        </div>
        <h1 class="text-center m-2">Lista de productos</h1>
        <table class="table table-light table-striped m-2">
            <thead>
                <tr>
                    <th>Codigo</th>
                    <th>Nombre</th>
                    <th>Precio (En Quetzales)</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>Manzana</td>
                    <td>10</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Banana</td>
                    <td>5</td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>Aguacate</td>
                    <td>8</td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>Fresa</td>
                    <td>2</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>Limon</td>
                    <td>7</td>
                </tr>
                <tr>
                    <td>6</td>
                    <td>Arandanos</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>7</td>
                    <td>Lomito</td>
                    <td>30</td>
                </tr>
                <tr>
                    <td>8</td>
                    <td>Puyaso</td>
                    <td>20</td>
                </tr>
                <tr>
                    <td>9</td>
                    <td>Nesquick</td>
                    <td>25</td>
                </tr>
                <tr>
                    <td>10</td>
                    <td>Cherios</td>
                    <td>30</td>
                </tr>
                <tr>
                    <td>11</td>
                    <td>Pescado</td>
                    <td>20</td>
                </tr>
            </tbody>
        </table>
    </div>

</main>

@include('footer')
