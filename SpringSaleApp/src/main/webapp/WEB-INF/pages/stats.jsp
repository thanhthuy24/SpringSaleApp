<%-- 
    Document   : stats
    Created on : Jul 29, 2024, 8:32:28 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-primary">THONG KE BAO CAO DOANH THU</h1>

<div class="row">
    <div class="col-md-5 col-12">
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Revenue</th>
            </tr>
            <c:forEach items="${revenues}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]}</td>
                    <td>${String.format("%,d", r[2])} VND</td>
                </tr>
            </c:forEach>

        </table>
    </div>
    <div class="col-md-7 col-12">
        <canvas id="myChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    window.onload = function () {
        let labels = [];
        let data = [];
        
    <c:forEach items="${revenues}" var="r">
            labels.push('${r[1]}');
            data.push('${r[2]}');
    </c:forEach>
        const ctx = document.getElementById('myChart');

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                        label: '# Doanh thu',
                        data: data,
                        borderWidth: 1
                    }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    }
</script>